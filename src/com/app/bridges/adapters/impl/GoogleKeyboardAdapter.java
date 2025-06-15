package com.app.bridges.adapters.impl;

import com.app.bridges.adapters.WriterAdapter;
import com.app.bridges.objects.TypeWriter;

import io.sdk.google.GoogleKeyboard;

public class GoogleKeyboardAdapter implements WriterAdapter {

	private GoogleKeyboard googleKeyboard;

	public GoogleKeyboardAdapter() {

	}

	public GoogleKeyboardAdapter(GoogleKeyboard googleKeyboard) {

		this.googleKeyboard = googleKeyboard;
	}

	public GoogleKeyboard get() {
		return this.googleKeyboard;
	}

}
