package com.app.bucket;

import java.io.File;

//Amazon S3 - Bucket. John Doe
public class Bucket implements BucketOperator {

	
	@Override
	public Bucket init() {
		return this;
	}

	@Override
	public Bucket load() {
		return this;
	}

	@Override
	public Bucket create() {
		return this;
	}

	@Override
	public Bucket store(Object... objects) {
		return this;
	}

	@Override
	public Bucket retrieve(int... ids) {
		return this;
	}

	@Override
	public Bucket search(int... ids) {
		return this;
	}

	@Override
	public Bucket list() {
		return this;
	}

	public static void main(String[] args) {

		// sample contract - 1;
		Bucket memories = new Bucket();
		memories = memories.init().create();
		memories = memories.load();

		File[] photos = new File[] { new File("mall.jpg"), new File("restaurant.jpg"), new File("instabul.jpg") };
		File[] music = new File[] { new File("hustling.mp3"), new File("win.mp3"), new File("mozart.mp3") };
		
		memories = memories.store(photos, music);
		memories = memories.search(null);
		memories.list();
		
		// sample contract - 2;
		Bucket artifacts = new Bucket();
		artifacts.init().create().load().store(music, photos).list();
		

	}

}
