package com.devaldi.events
{
	import flash.events.Event;
	
	public class SwfLoadedEvent extends Event
	{
		public static const SWFLOADED:String = "onSwfLoadedEvent";
		public var swfObject:Object;
		
		public function SwfLoadedEvent(type:String,target:Object){
			super(type);
			swfObject=target;
		}
		
		// Override the inherited clone() method.
		override public function clone():Event {
			return new SwfLoadedEvent(type, swfObject);
		}
		
	}
}