package AWS_s3.s3;

import java.util.List;
import com.amazonaws.services.s3.model.Bucket;

public class ListBucket {
	List<Bucket> buckets = new CreateBucket().s3Client.listBuckets();
	public void showBuckets() {
		System.out.println("Buckets available in your S3 storage are :");
		for(Bucket bucket:buckets) {
			System.out.println(bucket.getName());
		}
	}
}
	
