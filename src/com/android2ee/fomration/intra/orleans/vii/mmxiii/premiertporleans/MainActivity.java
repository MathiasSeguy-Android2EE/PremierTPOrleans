package com.android2ee.fomration.intra.orleans.vii.mmxiii.premiertporleans;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends FragmentActivity {

	/**
	 * The tag for the log
	 */
	private final String tag = "MainActivity";
	/**
	 * The Alert Dialog constant
	 */
	 static final int AlertDialogId = 110274;
	 /**
	 * The fragment
	 */
	MyFragment fragment;
	/******************************************************************************************/
	/** Managing LifeCycle **************************************************************************/
	/******************************************************************************************/
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.w(tag, "onCreate");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		fragment = (MyFragment) getSupportFragmentManager().findFragmentById(R.id.myfragment);
       

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onRestart()
	 */
	@Override
	protected void onRestart() {
		Log.w(tag, "onRestart");
		super.onRestart();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onStart()
	 */
	@Override
	protected void onStart() {
		Log.w(tag, "onStart");
		super.onStart();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onResume()
	 */
	@Override
	protected void onResume() {
		Log.w(tag, "onResume");
		super.onResume();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onPause()
	 */
	@Override
	protected void onPause() {
		Log.w(tag, "onPause");
		super.onPause();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onStop()
	 */
	@Override
	protected void onStop() {
		Log.w(tag, "onStop");
		super.onStop();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onDestroy()
	 */
	@Override
	protected void onDestroy() {
		Log.w(tag, "onDestroy");
		super.onDestroy();
	}

	/******************************************************************************************/
	/** Dialog Management **************************************************************************/
	/******************************************************************************************/
	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onCreateDialog(int, android.os.Bundle)
	 */
	@Override
	protected Dialog onCreateDialog(int id) {
		Dialog dialog;
		switch (id) {
		case AlertDialogId:
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setMessage(getString(R.string.dialog_message));
			builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
					 fragment.updateEditText();
				}
			});
			builder.setNegativeButton("No", null);
			dialog = builder.create();
			break;
		default:
			dialog = null;
		}
		return dialog;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onOptionsItemSelected(android.view.MenuItem)
	 */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		return super.onOptionsItemSelected(item);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onContextItemSelected(android.view.MenuItem)
	 */
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		return super.onContextItemSelected(item);
	}

	

	/******************************************************************************************/
	/** Managing Menu **************************************************************************/
	/******************************************************************************************/

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds humans to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
