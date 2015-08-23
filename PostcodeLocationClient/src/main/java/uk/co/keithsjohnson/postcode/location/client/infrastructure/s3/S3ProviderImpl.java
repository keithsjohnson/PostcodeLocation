package uk.co.keithsjohnson.postcode.location.client.infrastructure.s3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import uk.co.keithsjohnson.postcode.location.client.api.StoreProvider;

@Component
public class S3ProviderImpl implements StoreProvider {

	@Autowired
	private S3FileUploader s3FileUploader;

	@Override
	public void store(String key, String filename) {
		s3FileUploader.store(key, filename);
	}
}
