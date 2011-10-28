package com.devaldi.events
{
	import com.devaldi.controls.flexpaper.FitModeEnum;
	
	import flash.events.Event;
	
	public class FitModeChangedEvent extends Event
	{
		public static const FITMODE_CHANGED:String = "onFitModeChanged";
		public var fitMode:String;
		
		public function FitModeChangedEvent(type:String,fitmode:String)
		{
			super(type);
			fitMode = fitmode;
		}
		
		// Override the inherited clone() method.
		override public function clone():Event {
			return new FitModeChangedEvent(type, fitMode);
		}
	}
}