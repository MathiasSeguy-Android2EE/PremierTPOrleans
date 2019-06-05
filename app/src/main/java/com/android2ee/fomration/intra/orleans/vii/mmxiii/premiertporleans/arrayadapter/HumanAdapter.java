/**<ul>
 * <li>PremierTPOrleans</li>
 * <li>com.android2ee.fomration.intra.orleans.vii.mmxiii.premiertporleans.arrayadapter</li>
 * <li>15 juil. 2013</li>
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
package com.android2ee.fomration.intra.orleans.vii.mmxiii.premiertporleans.arrayadapter;

import java.util.List;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.android2ee.fomration.intra.orleans.vii.mmxiii.premiertporleans.R;
import com.android2ee.fomration.intra.orleans.vii.mmxiii.premiertporleans.model.Human;

/**
 * @author Mathias Seguy (Android2EE)
 * @goals
 *        This class aims to:
 *        <ul>
 *        <li></li>
 *        </ul>
 */
public class HumanAdapter extends ArrayAdapter<Human> {

	private LayoutInflater inflater;

	/**
	 * @param context
	 * @param textViewResourceId
	 */
	public HumanAdapter(Context context, List<Human> humans) {
		super(context, R.layout.human_list_layout, humans);
		// factorisation des ressources
		inflater = LayoutInflater.from(context);
		// ?o? others
	}

	// Avoid using TempVariable
	// always declare them as members variable or static variable members
	private View rowView;
	private ViewHolder viewHolder;
	private Human human;

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.widget.ArrayAdapter#getView(int, android.view.View, android.view.ViewGroup)
	 */
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		rowView = convertView;
		if (null == rowView) {
			if (getItemViewType(position) == 0) {
				// create the view
				rowView = inflater.inflate(R.layout.human_list_layout, null);
			} else {
				// create the view
				rowView = inflater.inflate(R.layout.human_list_layout_odd, null);
			}
			// create the viewHolder
			viewHolder = new ViewHolder(rowView);
			// link the view and its holder
			rowView.setTag(viewHolder);
		}
		// rowView!=null et rowView.getTag=ViewHolder
		viewHolder = (ViewHolder) rowView.getTag();
		// find the human to display
		human = getItem(position);
		viewHolder.getTxvName().setText(human.getName());
		viewHolder.getTxvMessage().setText(human.getMessage());
		return rowView;

	}
	
	
	/******************************************************************************************/
	/** Managing multiLayout **************************************************************************/
	/******************************************************************************************/

	@Override
	public int getViewTypeCount() {
		// return the number of type managed by the list view:
		// We have two types, one for the even line, the other for the odd lines
		return 2;
	}

	@Override
	public int getItemViewType(int position) {
		// return the type of the element to be displayed at position position
		// We have two types, one for the even line, the other for the odd lines
		return position % 2;
	}

	/**
	 * @author Mathias Seguy (Android2EE)
	 * @goals
	 *        This class aims to:
	 *        <ul>
	 *        <li></li>
	 *        </ul>
	 */
	private static class ViewHolder {
		View rowView;
		TextView txvName;
		TextView txvMessage;

		/**
		 * @param rowView
		 */
		private ViewHolder(View rowView) {
			super();
			this.rowView = rowView;
		}

		/**
		 * @return the txvName
		 */
		public final TextView getTxvName() {
			if (null == txvName) {
				txvName = (TextView) rowView.findViewById(R.id.txv_human_name);
			}
			return txvName;
		}

		/**
		 * @return the txvMessage
		 */
		public final TextView getTxvMessage() {
			if (null == txvMessage) {
				txvMessage = (TextView) rowView.findViewById(R.id.txv_human_message);
			}
			return txvMessage;
		}
	}

}
