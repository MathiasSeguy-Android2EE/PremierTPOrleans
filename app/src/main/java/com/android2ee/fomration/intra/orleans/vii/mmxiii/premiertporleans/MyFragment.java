/**<ul>
 * <li>PremierTPOrleans</li>
 * <li>com.android2ee.fomration.intra.orleans.vii.mmxiii.premiertporleans</li>
 * <li>19 juil. 2013</li>
 * 
 * <li>======================================================</li>
 *
 * <li>Projet : Mathias Seguy Project</li>
 * <li>Produit par MSE.</li>
 *
 /**
 * <ul>
 * Android Tutorial, An <strong>Android2EE</strong>'s project.</br> 
 * Produced by <strong>Dr. Mathias SEGUY</strong>.</br>
 * Delivered by <strong>http://android2ee.com/</strong></br>
 *  Belongs to <strong>Mathias Seguy</strong></br>
 ****************************************************************************************************************</br>
 * This code is free for any usage but can't be distribute.</br>
 * The distribution is reserved to the site <strong>http://android2ee.com</strong>.</br>
 * The intelectual property belongs to <strong>Mathias Seguy</strong>.</br>
 * <em>http://mathias-seguy.developpez.com/</em></br> </br>
 * 
 * *****************************************************************************************************************</br>
 *  Ce code est libre de toute utilisation mais n'est pas distribuable.</br>
 *  Sa distribution est reservée au site <strong>http://android2ee.com</strong>.</br> 
 *  Sa propriété intellectuelle appartient à <strong>Mathias Seguy</strong>.</br>
 *  <em>http://mathias-seguy.developpez.com/</em></br> </br>
 * *****************************************************************************************************************</br>
 */
package com.android2ee.fomration.intra.orleans.vii.mmxiii.premiertporleans;

import java.util.ArrayList;
import java.util.List;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.PopupMenu.OnMenuItemClickListener;
import android.widget.Toast;

import com.android2ee.fomration.intra.orleans.vii.mmxiii.premiertporleans.arrayadapter.HumanAdapter;
import com.android2ee.fomration.intra.orleans.vii.mmxiii.premiertporleans.model.Human;

/**
 * @author Mathias Seguy (Android2EE)
 * @goals
 *        This class aims to:
 *        <ul>
 *        <li></li>
 *        </ul>
 */
public class MyFragment extends Fragment {
	/**
	 * The tag for the log
	 */
	private final String tag = "FragmentActivity";
	/**
	 * 
	 */
	private static final String POSITION_ITEM = "Position_Item";

	/**
	 * Key used to store the Edt values in the bundle savedInstanceState/outState
	 */
	private final String EdtStorageKey = "edt";
	/**
	 * Key used to store the ListView values in the bundle savedInstanceState/outState
	 */
	private final String LsvStorageKey = "txv";
	/**
	 * Bouton Add
	 */
	private Button btnAdd;
	/**
	 * ListView that displays the list of added words
	 */
	private ListView lsvWordsList;
	/**
	 * ArrayAdapter of the ListView
	 */
	private HumanAdapter humanAdapter;
	/**
	 * The list of string displayed by the listView
	 */
	private List<Human> humans;
	/**
	 * The EditText that contains the message to be added
	 */
	private EditText edtMessage;

	/**
	 * The position of the selected human
	 */
	private int selectedHuman;
	/**
	 * The in Animation for before HC
	 */
	Animation animIn;
	/**
	 * The in Animation for after HC
	 */
	AnimatorSet animInHC;
	PopupMenu popupMenu;

	/******************************************************************************************/
	/** StoreAndRestore **************************************************************************/
	/******************************************************************************************/
	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onSaveInstanceState(android.os.Bundle)
	 */
	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putString(EdtStorageKey, edtMessage.getText().toString());
		// outState.putStringArrayList(LsvStorageKey, (ArrayList<String>) humans);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see androidx.fragment.app.Fragment#onViewStateRestored(android.os.Bundle)
	 */
	@Override
	public void onViewStateRestored(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onViewStateRestored(savedInstanceState);
		// Do the stuff in onActivityCreate:
		// edtMessage.setText(savedInstanceState.getString(EdtStorageKey));
		// // humans.addAll(savedInstanceState.getStringArrayList(LsvStorageKey));
		// humanAdapter.notifyDataSetChanged();
	}

	/******************************************************************************************/
	/** Managing life cycle **************************************************************************/
	/******************************************************************************************/

	/*
	 * (non-Javadoc)
	 * 
	 * @see androidx.fragment.app.Fragment#onCreateView(android.view.LayoutInflater,
	 * android.view.ViewGroup, android.os.Bundle)
	 */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.fragment_layout, container, false);
		// GUI instantiation
		btnAdd = (Button) view.findViewById(R.id.btnAdd);
		lsvWordsList = (ListView) view.findViewById(R.id.lsvWordsList);
		edtMessage = (EditText) view.findViewById(R.id.edtMessage);
		popupMenu=new PopupMenu(getActivity(),btnAdd);
		popupMenu.inflate(R.menu.main);
		popupMenu.setOnMenuItemClickListener(new OnMenuItemClickListener() {			
			@Override
			public boolean onMenuItemClick(MenuItem item) {
				switch(item.getItemId()) {
				case R.id.action_settings:
					//do a stuff
					Toast.makeText(getActivity(), "PopUpMenu has been clicked : "+item.getTitle(), Toast.LENGTH_LONG).show();
					return true;
				}
				return false;
			}
		});
		return view;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see androidx.fragment.app.Fragment#onActivityCreated(android.os.Bundle)
	 */
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		Context ctx = getActivity();
		if (savedInstanceState != null) {
			edtMessage.setText(savedInstanceState.getString(EdtStorageKey));
		}
		if (getResources().getBoolean(R.bool.post_honeyComb)) {
			animInHC = (AnimatorSet) AnimatorInflater.loadAnimator(ctx, R.anim.anim_push_left_in);
			animInHC.setTarget(edtMessage);
			animInHC.setTarget(btnAdd);
			animInHC.setTarget(lsvWordsList);
			animInHC.start();
		} else {
			animIn = AnimationUtils.loadAnimation(ctx, R.anim.anim_push_left_in);
		}
		// animIn = AnimationUtils.loadAnimation(this, R.anim.anim_push_left_in);
		// animOut = AnimationUtils.loadAnimation(this, R.anim.anim_push_right_out);
		// Instantiate listView elements
		humans = new ArrayList<Human>();
		humanAdapter = new HumanAdapter(ctx, humans);
		lsvWordsList.setAdapter(humanAdapter);
		// Adding listener
		btnAdd.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				add();
			}
		});
		lsvWordsList.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				listItemSelected(position);
			}
		});
		super.onActivityCreated(savedInstanceState);
	}

	/******************************************************************************************/
	/** Managing listView **************************************************************************/
	/******************************************************************************************/
	/**
	 * When a ListItemSelected
	 * 
	 * @param position
	 */
	private void listItemSelected(int position) {
		Log.e(tag, "Selected item : " + position);
		selectedHuman = position;
		getActivity().showDialog(MainActivity.AlertDialogId);
		
	}

	/**
	 * Update the EditText using the human at the position position
	 * 
	 * @param position
	 *            The position of the human to update editText
	 */
	public void updateEditText() {
		edtMessage.setText(humanAdapter.getItem(selectedHuman).getMessage());
		popupMenu.show();
	}

	/******************************************************************************************/
	/** Managing Add **************************************************************************/
	/******************************************************************************************/
	/**
	 * Method called when the add button is clicked
	 */
	private void add() {
		// find the editText's string
		String data = edtMessage.getText().toString();
		// Create pipo human
		Human pipoHuman = new Human(data);
		// then add to the list
		humans.add(pipoHuman);
		// and notify the humanAdapter
		humanAdapter.notifyDataSetChanged();
		// or directly add it to the adapter
		// humanAdapter.add(data);
		edtMessage.setText("");

		if (getResources().getBoolean(R.bool.post_honeyComb)) {
			animInHC.start();
		} else {
			edtMessage.startAnimation(animIn);
		}

	}
}
