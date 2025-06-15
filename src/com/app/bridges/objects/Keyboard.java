package com.app.bridges.objects;

import java.util.function.Supplier;

import com.app.bridges.adapters.WriterAdapter;
import com.app.bridges.adapters.abstracts.AbstractWriterAdapter;
import com.app.bridges.adapters.impl.GoogleKeyboardAdapter;
import com.app.bridges.adapters.lambdas.LambdaWriterAdapter;
import com.app.bridges.writers.NumberWriter;
import com.app.bridges.writers.TextWriter;

import io.sdk.google.GoogleKeyboard;

import static com.app.bridges.adapters.lambdas.LambdaWriterAdapter.MICROSOFT;
import static com.app.bridges.adapters.lambdas.LambdaWriterAdapter.GOOGLE;
import static com.app.bridges.adapters.lambdas.LambdaWriterAdapter.CHAT_GPT;
import static com.app.bridges.adapters.lambdas.LambdaWriterAdapter.APPLE;
import static com.app.bridges.adapters.lambdas.LambdaWriterAdapter.SAMSUNG;;

public class Keyboard {

	TextWriter textWriter; // write text

	NumberWriter numberWriter; // write numbers

	WriterAdapter writerAdapter; // marker interface

	AbstractWriterAdapter abstractWriterAdapter; // abstract class

	public Keyboard(NumberWriter numberWriter) {
		this.numberWriter = numberWriter;
	}

	// accepts commericial off the shelf products to be used as keyboard
	public Keyboard(WriterAdapter writerAdapter) {
		this.writerAdapter = writerAdapter;
	}

	// abstract class
	public Keyboard(AbstractWriterAdapter abstractWriterAdapter) {
		this.abstractWriterAdapter = abstractWriterAdapter;
	}

	// abstract class
	public Keyboard(LambdaWriterAdapter lambda) {

		WriterAdapter writerAdapter = lambda.writerAdapterInstance();

		if (writerAdapter.toString().contains(SAMSUNG.toLowerCase())) {
			this.writerAdapter = writerAdapter;
		} else if (writerAdapter.toString().contains(APPLE.toLowerCase())) {
			this.writerAdapter = writerAdapter;
		} else if (writerAdapter.toString().contains(GOOGLE.toLowerCase())) {
			this.writerAdapter = writerAdapter;
		} else if (writerAdapter.toString().contains(CHAT_GPT.toLowerCase())) {
			this.writerAdapter = writerAdapter;
		}else if (writerAdapter.toString().contains(MICROSOFT.toLowerCase())) {
			this.writerAdapter = writerAdapter;
		}


	}

	public Keyboard(TextWriter textWriter) {
		this.textWriter = textWriter;
	}

	public Keyboard(TextWriter textWriter, NumberWriter numberWriter) {
		this.textWriter = textWriter;
		this.numberWriter = numberWriter;

	}

	public Keyboard() {
	}

	public void write(String text) {

	}

	public void write(int i) {

	}

}
