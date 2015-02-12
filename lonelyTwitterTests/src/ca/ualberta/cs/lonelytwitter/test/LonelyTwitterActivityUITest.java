package ca.ualberta.cs.lonelytwitter.test;

import java.util.Date;

import android.app.Activity;
import android.app.Instrumentation;
import android.test.ActivityInstrumentationTestCase2;
import android.test.ViewAsserts;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity;
import ca.ualberta.cs.lonelytwitter.NormalTweetModel;

/*
 * generate this class with new.. JUnit Test Case
 * set superclass to ActivityInstrumentationTestCase2
 */
public class LonelyTwitterActivityUITest extends
		ActivityInstrumentationTestCase2<LonelyTwitterActivity> {

	Instrumentation instrumentation;
	Activity activity;
	EditText textInput;

	public LonelyTwitterActivityUITest() {
		super(LonelyTwitterActivity.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
		instrumentation = getInstrumentation();
		activity = getActivity();

		textInput = ((EditText) activity
				.findViewById(ca.ualberta.cs.lonelytwitter.R.id.body));
	}

	public void testSetText() {
		final String text = "tweet";

		instrumentation.runOnMainSync(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				textInput.setText(text);
			}
		});
		instrumentation.waitForIdleSync();
		assertEquals("correct text?", text, textInput.getText().toString());
	}
	
	public void testNewThing(){
		final String text = "tweet";
		NormalTweetModel ntm = new NormalTweetModel(text);
		assertTrue("correct text?",ntm.equals(new NormalTweetModel(text)));
	}
	
	/*
	 * fills in the input text field and clicks the 'save' button for the
	 * activity under test
	 */
	private void makeTweet(String text) {
		assertNotNull(activity
				.findViewById(ca.ualberta.cs.lonelytwitter.R.id.save));
		textInput.setText(text);
		((Button) activity.findViewById(ca.ualberta.cs.lonelytwitter.R.id.save))
				.performClick();
	}
}
