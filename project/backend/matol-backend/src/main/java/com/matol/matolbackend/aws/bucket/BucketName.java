package com.matol.matolbackend.aws.bucket;

public enum BucketName {

    PROFILE_IMAGE("matolbucket");

    private final String bucketName;

    BucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public String getBucketName() {
        return bucketName;
    }
}
