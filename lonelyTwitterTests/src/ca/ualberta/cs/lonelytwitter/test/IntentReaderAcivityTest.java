package ca.ualberta.cs.lonelytwitter.test;

import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import android.test.ViewAsserts;
import android.widget.TextView;
import ca.ualberta.cs.lonelytwitter.IntentReaderActivity;
import ca.ualberta.cs.lonelytwitter.R;

public class IntentReaderAcivityTest extends
		ActivityInstrumentationTestCase2<IntentReaderActivity> {

	public IntentReaderAcivityTest() {
		super(IntentReaderActivity.class);
		// TODO Auto-generated constructor stub
	}

	protected void setUp() throws Exception{
		super.setUp();
	}
	
	public void testSendText()
	{
		String text = "Hello world!";
		IntentReaderActivity activity = startWithText(text, IntentReaderActivity.NORMAL);
		assertEquals("got the text?", text, activity.getText());
	}
	
	public void testDoubleText(){
		String text = "Hello world!";
		IntentReaderActivity activity = startWithText(text, IntentReaderActivity.DOUBLE);
		assertEquals("double text?",  text+text, activity.getText());
	}

	public void testDisplayText(){
		String text = "Hello";
		IntentReaderActivity activity = startWithText(text, IntentReaderActivity.NORMAL);
		TextView view = (TextView) activity.findViewById(R.id.intentText);
		assertEquals("correct text?",  text, view.getText());
	}
	
	public void testReverseText(){
		String text = "Hello";
		IntentReaderActivity activity = startWithText(text, IntentReaderActivity.REVERSE);
		TextView view = (TextView) activity.findViewById(R.id.intentText);
		assertEquals("correct text?",  "olleH", view.getText());
	}
	
	public void testOnScreen()
	{
		String text = "Hello world!";
		IntentReaderActivity activity = startWithText(text, IntentReaderActivity.NORMAL);
		TextView view = (TextView) activity.findViewById(R.id.intentText);
		ViewAsserts.assertOnScreen(activity.getWindow().getDecorView(), view);
		
	}
	
	private IntentReaderActivity startWithText(String text, int mode){
		Intent intent = new Intent();
		intent.putExtra(IntentReaderActivity.TEXT_KEY, text);
		intent.putExtra(IntentReaderActivity.TRANSFORM_KEY, mode);
		setActivityIntent(intent);
		return (IntentReaderActivity) getActivity();
	}
	
}
