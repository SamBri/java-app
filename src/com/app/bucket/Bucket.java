package com.app.bucket;

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
	
	
	
	public static void main(String[] args) {
		
		// sample contract.
		Bucket memories = new Bucket();
		
	}
  
	
	

}
