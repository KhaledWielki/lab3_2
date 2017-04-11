package edu.iis.mto.staticmock;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import edu.iis.mto.staticmock.reader.NewsReader;

import static org.powermock.api.mockito.PowerMockito.*;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

@PrepareForTest ({NewsReaderFactory.class, ConfigurationLoader.class, PublishableNews.class})
@RunWith(PowerMockRunner.class)

public class NewsLoaderUnitTests {

	private ConfigurationLoader mockConfigurationLoader;
	private Configuration config;
	private IncomingNews incomingNews;
	private NewsReader testNewsReader;
	private NewsLoader newsLoader;
	
	@Before
 	public void initialize() {
 		mockStatic(ConfigurationLoader.class);
 		mockConfigurationLoader = mock(ConfigurationLoader.class);
 		when(ConfigurationLoader.getInstance()).thenReturn(mockConfigurationLoader);
 		
 		config = new Configuration();
 		Whitebox.setInternalState(config, "readerType","testType");
 		when(ConfigurationLoader.getInstance().loadConfiguration()).thenReturn(config);
 		
 		incomingNews = new IncomingNews();
 		incomingNews.add(new IncomingInfo("text1",SubsciptionType.NONE));
 		incomingNews.add(new IncomingInfo("text2",SubsciptionType.A));
 		incomingNews.add(new IncomingInfo("text3",SubsciptionType.NONE));
 		incomingNews.add(new IncomingInfo("text4",SubsciptionType.B));
 		incomingNews.add(new IncomingInfo("text5",SubsciptionType.C));
 		
 		testNewsReader = new NewsReader () {
 			@Override
 			public IncomingNews read() {
 				return incomingNews;
 			}
 		};
 		
 		mockStatic(NewsReaderFactory.class);
 		when(NewsReaderFactory.getReader("testType")).thenReturn(testNewsReader);
 		
  		newsLoader = new NewsLoader();
  	}
	
	@Test
	public void stateCaseTest() {
		PublishableNews result = newsLoader.loadNews();
	
		List<String> publicContent = Whitebox.getInternalState(result, "publicContent");
		
		assertThat(publicContent.size(),is(not(0)));
		assertThat(publicContent.get(0), is(equalTo("text1")));
	}
	
	@Test
	 public void behaviourCaseTest() {
  		PublishableNews result = newsLoader.loadNews();
  		
  		verify(mockConfigurationLoader, times(1)).loadConfiguration();
 	}
}
