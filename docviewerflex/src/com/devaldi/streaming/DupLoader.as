package com.devaldi.streaming
{
	import flash.display.Loader;
	 
	public class DupLoader extends flash.display.Loader
	{
		public var loaded:Boolean = false;
		public var loadingFrames:int = 0;
		public var pageStartIndex:int = 0;
		public var loading:Boolean = false;
	}
}