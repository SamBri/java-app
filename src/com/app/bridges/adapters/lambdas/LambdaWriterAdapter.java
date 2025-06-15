package com.app.bridges.adapters.lambdas;

import java.util.function.Supplier;

import com.app.bridges.adapters.WriterAdapter;


public interface LambdaWriterAdapter {

	public String SAMSUNG = "SAMSUNG";
	public String APPLE = "APPLE";
	public String GOOGLE = "GOOGLE";
	public String CHAT_GPT = "CHAT_GPT";
	public String MICROSOFT = "MICROSOFT";

	WriterAdapter writerAdapterInstance();

}
