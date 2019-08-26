package com.gikk.twirk.types;

import com.gikk.twirk.types.AbstractTwitchUserFields;
import com.gikk.twirk.types.TwitchMessage;

public class GikkDefault_UserstateBuilder extends AbstractTwitchUserFields implements UserstateBuilder {
	
	@Override
	public Userstate build(TwitchMessage message) {
		parseUserProperties(message);
		return new UserstateImpl(this);
	}
}
