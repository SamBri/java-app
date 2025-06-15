package com.app.bridges.adapters.impl;

import com.app.bridges.adapters.WriterAdapter;
import com.app.bridges.objects.TypeWriter;

public class TypeWriterKeyboardAdapter implements WriterAdapter {

	private TypeWriter typeWriter;

	public TypeWriterKeyboardAdapter() {

	}

	public TypeWriterKeyboardAdapter(TypeWriter typeWriter) {

		this.typeWriter = typeWriter;
	}

//	@Override
//	public TypeWriter newWriterAdapter(Object object) {
//
//		if (!(object instanceof TypeWriter)) {
//			return null;
//		}
//
//		return (TypeWriter) object;
//
//	}

	public TypeWriter get() {
		return this.typeWriter;
	}

}
