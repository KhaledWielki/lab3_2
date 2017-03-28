package edu.iis.mto.staticmock;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.powermock.api.mockito.PowerMockito.*;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

@PrepareForTest ({NewsReaderFactory.class, ConfigurationLoader.class, PublishableNews.class})
@RunWith(PowerMockRunner.class)

public class NewsLoaderUnitTests {

	private NewsLoader newsLoader;
	private IncomingNews incomingNews = new IncomingNews();
	private IncomingInfo incomingInfoPublishable = new IncomingInfo("incomingInfoPublishable", SubsciptionType.NONE);
	private IncomingInfo incomingInfoSubscriptionA = new IncomingInfo("incomingInfoSubsubscriptionA", SubsciptionType.A);
	

}
