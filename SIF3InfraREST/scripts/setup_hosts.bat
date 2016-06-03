@echo off

rem ============================================================================
rem == User defined environment variables                                     ==
rem ============================================================================

set HOSTS=..\Tools\Hosts\hosts.exe
set HOST_ENVIRONMENT=Sif.Framework.EnvironmentProvider
set HOST_PROVIDER=Sif.Framework.Demo.Uk.Provider

rem ============================================================================
rem == Safety checks                                                          ==
rem ============================================================================

if exist %HOSTS% goto okHOSTS
echo Could not find : %HOSTS%
pause
goto end
:okHOSTS

rem ============================================================================
rem == Start executable
rem ============================================================================

%HOSTS% add %HOST_ENVIRONMENT% %HOST_PROVIDER%
:end
