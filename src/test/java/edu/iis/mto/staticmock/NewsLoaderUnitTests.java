package edu.iis.mto.staticmock;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import edu.iis.mto.staticmock.reader.NewsReader;

import static org.powermock.api.mockito.PowerMockito.*;
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
	

}
