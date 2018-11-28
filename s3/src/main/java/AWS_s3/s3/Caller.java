package AWS_s3.s3;

import java.io.IOException;

public class Caller {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CreateBucket create = new CreateBucket();
		ListBucket list = new ListBucket();
		Operations operate = new Operations();
		try {
			create.createTheBucket();
			list.showBuckets();
			operate.putObjects();
			operate.listObjects();
			operate.downloadObject();
			operate.copyObject();
			operate.deleteObject();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
