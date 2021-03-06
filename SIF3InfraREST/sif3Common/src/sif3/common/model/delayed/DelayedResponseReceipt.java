/*
 * DelayedResponseReceipt.java
 * Created: 04/12/2015
 *
 * Copyright 2015 Systemic Pty Ltd
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License. 
 */

package sif3.common.model.delayed;

import java.io.Serializable;

import sif3.common.header.HeaderProperties;
import sif3.common.model.URLQueryParameter;

/**
 * This class is a POJO that holds some useful information about the response to a DELAYED request. It is up to the consumer to
 * decide what it wants to do with that receipt information. Ignore it, persist it or any other actions are all valid options.
 * 
 * @author Joerg Huber
 *
 */
public class DelayedResponseReceipt extends DelayedBaseReceipt implements Serializable
{
    private static final long serialVersionUID = -1965220525993041749L;

    // relative URI of the original request
    private String relativeRequestURI = null;
    
    private String msgReadID = null; // The ID of the message reader on the message queue.
    private String consumerID = null; // The ID of the consumer worker thread that is processing this message
    
	private URLQueryParameter queryParams = new URLQueryParameter();
    private HeaderProperties httpHeaders = new HeaderProperties();

	public URLQueryParameter getQueryParams()
	{
		return queryParams;
	}

	public void setQueryParams(URLQueryParameter queryParams)
	{
		this.queryParams = queryParams;
	}

	public HeaderProperties getHttpHeaders()
	{
		return httpHeaders;
	}

	public void setHttpHeaders(HeaderProperties httpHeaders)
	{
		this.httpHeaders = httpHeaders;
	}

	public String getRelativeRequestURI()
	{
		return relativeRequestURI;
	}

	public void setRelativeRequestURI(String relativeRequestURI)
	{
		this.relativeRequestURI = relativeRequestURI;
	}

    public String getMsgReadID()
	{
		return msgReadID;
	}

	public void setMsgReadID(String msgReadID)
	{
		this.msgReadID = msgReadID;
	}

	public String getConsumerID()
	{
		return consumerID;
	}

	public void setConsumerID(String consumerID)
	{
		this.consumerID = consumerID;
	}

	@Override
    public String toString()
    {
	    return "DelayedResponseReceipt [relativeRequestURI="
	            + relativeRequestURI + ", msgReadID=" + msgReadID
	            + ", consumerID=" + consumerID + ", queryParams=" + queryParams
	            + ", httpHeaders=" + httpHeaders + ", toString()="
	            + super.toString() + "]";
    }
}
