package com.gikk.twirk.events;

import java.util.Collection;

import com.gikk.twirk.types.ClearChat;
import com.gikk.twirk.types.HostTarget;
import com.gikk.twirk.types.Mode;
import com.gikk.twirk.types.Notice;
import com.gikk.twirk.types.Roomstate;
import com.gikk.twirk.types.SubscriberEvent;
import com.gikk.twirk.types.TwitchMessage;
import com.gikk.twirk.types.Usernotice;
import com.gikk.twirk.types.TwitchUser;
import com.gikk.twirk.types.Userstate;

/**Convenience class.<br>
 * Instead if extending the TwirkListener interface, you can instead extend this class. That
 * way, you only need to implement those methods that you want to use. This class implements
 * all required methods, but leaves the method body blank. Thus, you don't need to call the
 * {@code .super()} methods at all.
 * 
 * @author Gikkman
 *
 */
public abstract class TwirkListenerBaseImpl implements TwirkListener{

	@Override
	public void onAnything(String line) { }

	@Override
	public void onPrivMsg(TwitchUser sender, TwitchMessage message) {	}

	@Override
	public void onWhisper(TwitchUser sender, TwitchMessage message) {	}

	@Override
	public void onJoin(String joinedNick) { }

	@Override
	public void onPart(String partedNick) { }

	@Override
	public void onConnect() { }

	@Override
	public void onDisconnect() { }

	@Override
	public void onNotice(Notice notice) { }
	
	@Override
	public void onHost(HostTarget hostNotice) { }

	@Override
	public void onMode(Mode mode) { }
	
	@Override
	public void onSubscriberEvent(SubscriberEvent subscriberEvent) { }
	
	@Override
	public void onUserstate(Userstate userstate) { }
	
	@Override
	public void onRoomstate(Roomstate roomstate) { }
	
	@Override
	public void onClearChat(ClearChat clearChat) { }
	
	@Override
	public void onNamesList(Collection<String> namesList) { }
	
	@Override
	public void onUsernotice(Usernotice usernotice) { }

	@Override
	public void onUnknown(String line) { }	
}
