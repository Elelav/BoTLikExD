package com.gikk.twirk;

import org.junit.Test;

import com.gikk.twirk.types.TestClearChat;
import com.gikk.twirk.types.TestHostTarget;
import com.gikk.twirk.types.TestMode;
import com.gikk.twirk.types.TestNotice;
import com.gikk.twirk.types.TestRoomstate;
import com.gikk.twirk.types.TestSubscriberEvent;
import com.gikk.twirk.types.TestMessage;
import com.gikk.twirk.types.TestUsernotice;
import com.gikk.twirk.types.TestUserstate;

public class TestSuit {
	
	@Test
	public void testPrivMsg(){		
		//This one tests both TwitchMessage & TwitchUser
		TestMessage.testPrivMsg();
	}
	
	@Test
	public void testSubEvent(){
		TestSubscriberEvent.testSubEvent();
	}
	
	@Test
	public void testClearChat(){
		TestClearChat.test();
	}
	
	@Test
	public void testNotice(){
		TestNotice.test();
	}
	
	@Test
	public void testHost(){
		TestHostTarget.test();
	}
	
	@Test
	public void testMode(){
		TestMode.test();
	}
	
	@Test
	public void testRoomstate(){
		TestRoomstate.test();
	}
	
	@Test
	public void testUserstate(){
		TestUserstate.test();
	}
	
	@Test
	public void testUsernotice(){
		TestUsernotice.test();
	}
}
