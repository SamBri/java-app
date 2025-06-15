package com.app.bridges.adapters.abstracts.impl;

import com.app.bridges.adapters.abstracts.AbstractWriterAdapter;

import io.sdk.apple.AppleKeyboard;

public class AppleKeyboardAbstractWriterAdapterImpl extends AbstractWriterAdapter {

	private AppleKeyboard appleKeyboard;

	public AppleKeyboardAbstractWriterAdapterImpl() {

	}

	public AppleKeyboardAbstractWriterAdapterImpl(AppleKeyboard appleKeyboard) {

		this.appleKeyboard = appleKeyboard;
	}

	// coveriants returns
	@Override
	public AppleKeyboard get() {
		return this.appleKeyboard;
	}

}
