package AWS_s3.s3;

import java.io.File;

import org.apache.commons.io.FileUtils;

import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.services.s3.model.S3ObjectSummary;

public class Operations {
	String bucket_name = "$BUCKET_NAME";
	String key = "$BUCKET_FILE_PATH";
	String file = "$SOURCE_FILE_LOCATION";
	public void putObjects() {
		try {
			new CreateBucket().s3Client.putObject(bucket_name, key, file);
		}catch (Exception e) {
			System.out.println("error in putting the object - "+e);
		}
		System.out.println("Exiting Put");
	}
	public void listObjects() {
		try {
			ObjectListing objectListing = new CreateBucket().s3Client.listObjects(bucket_name);
			System.out.println("Objects in the bucket are :");
			for(S3ObjectSummary os : objectListing.getObjectSummaries()) {
			    System.out.println(os.getKey());
			}
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error in listing objects" + e);
			}
		System.out.println("Exiting List");
	}
	public void downloadObject() {
		try {
			S3Object s3object = new CreateBucket().s3Client.getObject(bucket_name, "$FILE_NAME");
			S3ObjectInputStream inputStream = s3object.getObjectContent();
			FileUtils.copyInputStreamToFile(inputStream, new File("$DESTINATION_PATH"));
			
		}catch(Exception e) {
			// TODO: handle exception
			System.out.println("Error in downloading object - " + e);
		}
		System.out.println("Exiting Download");
	}
	public void copyObject() {
		try {
			new CreateBucket().s3Client.copyObject(bucket_name, "$SOURCE_PATH", bucket_name, "$DESTINATION_PATH");
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error in moving - "+ e);
		}
		System.out.println("Exiting copy");
	}
	public void deleteObject() {
		try {
			new CreateBucket().s3Client.deleteObject(bucket_name, "$FILE_PATH");
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error in Deleting");
		}
		System.out.println("Exiting deletejhgjlhgjlgjklh");
		System.out.println("Exiting delete");
	}
	

}
