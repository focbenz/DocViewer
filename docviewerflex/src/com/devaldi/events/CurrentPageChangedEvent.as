package com.devaldi.events
{
	import flash.events.Event;
	
	public class CurrentPageChangedEvent extends Event
	{
		public static const PAGE_CHANGED:String = "onCurrPageChanged";
		public var pageNum:Number;
		
		public function CurrentPageChangedEvent(type:String,p:Number){
			super(type);
			pageNum=p;
		}
		
		// Override the inherited clone() method.
		override public function clone():Event {
			return new CurrentPageChangedEvent(type, pageNum);
		}
		
	}
}