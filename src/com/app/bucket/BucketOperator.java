package com.app.bucket;

public interface BucketOperator {

	// init
	public Bucket init();

	// load
	public Bucket load();

	// create
	public Bucket create();

	// store
	public Bucket store(Object... objects);

	// retrieve
	public Bucket retrieve(int... ids);

	// search
	public Bucket search(int... ids);

}
