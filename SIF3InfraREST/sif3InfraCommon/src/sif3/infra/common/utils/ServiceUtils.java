package sif3.infra.common.utils;

import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import sif3.common.model.ServiceRights.AccessRight;
import sif3.common.model.ServiceRights.AccessType;
import sif3.infra.common.ServiceStatus.JobState;
import sif3.infra.common.ServiceStatus.PhaseState;
import sif3.infra.common.model.JobType;
import sif3.infra.common.model.ObjectFactory;
import sif3.infra.common.model.PhaseType;
import sif3.infra.common.model.RightType;
import sif3.infra.common.model.StateType;

public class ServiceUtils {
	private static ObjectFactory objectFactory = new ObjectFactory();
	
	public static PhaseType getPhase(JobType job, String phaseName) {
		if(job.getPhases() == null) {
			job.setPhases(objectFactory.createPhaseCollectionType());
		}
		for(PhaseType phase : job.getPhases().getPhase()) {
			if(phase.getName().equals(phaseName)) {
				return phase;
			}
		}
		return null;
	}
	
	public static StateType getLastPhaseState(JobType job, String phaseName) {
		PhaseType phase = getPhase(job, phaseName);
		if(phase == null) {
			return null;
		}
		if(phase.getStates() == null) {
			return null;
		}
		List<StateType> states = phase.getStates().getState();
		if(states.isEmpty()) {
			return null;
		}
		return states.get(states.size()-1);
	}
	
	public static PhaseType addPhase(JobType job, String phaseName, boolean required, List<RightType> rights) {
		return addPhase(job, phaseName, required, rights, PhaseState.NOTSTARTED, null);
	}
	
	public static PhaseType addPhase(JobType job, String phaseName, boolean required, List<RightType> rights, PhaseState state) {
		return addPhase(job, phaseName, required, rights, state, null);
	}

	public static PhaseType addPhase(JobType job, String phaseName, boolean required, List<RightType> rights, PhaseState state, String stateDescription) {
		if(job.getPhases() == null) {
			job.setPhases(objectFactory.createPhaseCollectionType());
		}
		PhaseType phase = objectFactory.createPhaseType();
		phase.setName(phaseName);
		phase.setRequired(required);
		phase.setStates(objectFactory.createStateCollectionType());
		phase.setRights(objectFactory.createRightsType());
		phase.getRights().getRight().addAll(rights);
		
		job.getPhases().getPhase().add(phase);
		
		changePhaseState(job, phase, state, stateDescription);
		
		return phase;
	}
	
	public static boolean checkPhaseACL(PhaseType phase, AccessRight right, AccessType type) {
		SIFRights rights = new SIFRights().setRights(phase.getRights());
		return rights.hasRight(right, type);
	}
	
	public static void changeJobState(JobType job, JobState state, String description)
  {
		job.setLastModified(Calendar.getInstance(TimeZone.getTimeZone("UTC")));
		job.setStateDescription(description);
		job.setState(state.name());
  }
	
	public static StateType changePhaseState(JobType job, PhaseType phase, PhaseState state, String description)
  {
		if(!job.getPhases().getPhase().contains(phase)) {
			throw new IllegalArgumentException("Phase with name " + phase.getName() + " Does not belong to job with refid " + job.getId());
		}
		
		StateType current = null;
		try {
			current = phase.getStates().getState().get(phase.getStates().getState().size() - 1);
		}catch(Exception e) {
			// Do nothing
		}
		
		Calendar time = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
		
    if(current == null || !current.getType().equals(state))
    {
    	current = objectFactory.createStateType();
    	current.setType(state.name());
    	current.setCreated(time);
    	phase.getStates().getState().add(current);
    }
    current.setLastModified(time);
    current.setDescription(description);
    
		job.setLastModified(time);
		
		return current;
  }
}
