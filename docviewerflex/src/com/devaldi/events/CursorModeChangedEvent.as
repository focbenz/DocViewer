package com.devaldi.events
{
	import flash.events.Event;
	
	public class CursorModeChangedEvent extends Event
	{
		public static const CURSORMODE_CHANGED:String = "onCursorModeChanged";
		public var cursorMode:String;
		
		public function CursorModeChangedEvent(type:String,cursormode:String)
		{
			super(type);
			cursorMode = cursormode;
		}
		
		// Override the inherited clone() method.
		override public function clone():Event {
			return new CursorModeChangedEvent(type, cursorMode);
		}
	}
}