/*
 * Copyright (C) 2019  Clemens Bartz
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package de.clemensbartz.android.launcher.listeners;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ListView;

import java.lang.ref.WeakReference;

/**
 * Click listener for clicking on a section label.
 * @since 2.1
 * @author Clemens Bartz
 */
public class SectionLabelOnClickListener implements View.OnClickListener {

    /** The weak reference to the list view. */
    @NonNull
    private final WeakReference<ListView> listViewWeakReference;
    /** The position to smoothly scroll to. */
    private final int position;

    /**
     * Create a new listener to click on a list view.
     * @param listView the list view to click
     * @param position the position to scroll to
     */
    public SectionLabelOnClickListener(@Nullable final ListView listView, final int position) {
        this.listViewWeakReference = new WeakReference<>(listView);
        this.position = position;
    }

    @Override
    public void onClick(@Nullable final View v) {
        final ListView listView = listViewWeakReference.get();

        if (listView != null) {
            listView.smoothScrollToPosition(position);
        }
    }
}