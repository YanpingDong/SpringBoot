package org.utilities;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;

import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.TrustStrategy;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * Hello world!
 *
 */
public class CommonUtilities 
{
    public static void testFunciont()
    {
    	System.out.println("good");
    }
    
    private HttpComponentsClientHttpRequestFactory getRequestFactory () {
		// Work only for httpClient 4.4+
		SSLContext sslContext = null;
		try {
			sslContext = new SSLContextBuilder().loadTrustMaterial(null,
					new TrustStrategy() {
						@Override
						public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
				            return true;
						}
					}
				).build();
		} catch (KeyManagementException | NoSuchAlgorithmException | KeyStoreException e) {
			e.printStackTrace();
		}
				
		CloseableHttpClient httpClient
			= HttpClients.custom().setSSLHostnameVerifier(new NoopHostnameVerifier())
							 	  .setSSLContext(sslContext)
						 .build();
		
		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
		requestFactory.setHttpClient(httpClient);
		
		return requestFactory;
	}
    
    public RestTemplate getHttpsRestTemplate()
    {
    	RestTemplate restTemplate = new RestTemplate(getRequestFactory());
    	return restTemplate;
    }
    
}
