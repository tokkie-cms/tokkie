package com.tokkiecms.common.web.rest.model;

import java.util.List;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import org.springframework.http.HttpStatus;

/**
 * A common wrapper for enforcing consistent response format.
 *
 * @param <T> type of the result(s) in response.
 */
@XmlRootElement(name = "response")
public class Response<T>
{
	@XmlElement(name = "code")
	private String code;

	@XmlElement(name = "message")
	private String message;

	@XmlElement(name = "result")
	private T result;

	@XmlElement(name = "results")
	private List<T> results;

	public Response()
	{
	}

	public Response(final HttpStatus status, final String message)
	{
		this(status.toString(), message);
	}

	public Response(final String code, final String message)
	{
		this.code = code;
		this.message = message;
	}

	public Response(final T result)
	{
		this.code = String.valueOf(HttpStatus.OK.value());
		this.result = result;
	}

	public Response(final List<T> results)
	{
		this.code = String.valueOf(HttpStatus.OK.value());
		this.results = results;
	}

	public String getCode()
	{
		return this.code;
	}

	public void setCode(final String code)
	{
		this.code = code;
	}

	public String getMessage()
	{
		return this.message;
	}

	public void setMessage(final String message)
	{
		this.message = message;
	}

	public T getResult()
	{
		return this.result;
	}

	public void setResult(final T result)
	{
		this.result = result;
	}

	public List<T> getResults()
	{
		return this.results;
	}

	public void setResults(final List<T> results)
	{
		this.results = results;
	}
}
