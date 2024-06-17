package com.pierfrancescosoffritti.androidyoutubeplayer.core.player.utils

import android.view.View
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YoutubePlayerMuteListener

internal class MuteHelper(private val targetView: View) {

    var isMute: Boolean = false
        private set

    private val muteListeners: MutableSet<YoutubePlayerMuteListener> = HashSet()

    fun muteOn() {
        if (isMute) return

        isMute = true

        for (muteListener in muteListeners)
            muteListener.onYoutubePlayerMuteOn()
    }

    fun muteOff() {
        if (!isMute) return

        isMute = false

        for (muteListener in muteListeners)
            muteListener.onYoutubePlayerMuteOff()
    }

    fun toggleMute() {
        if (isMute) muteOff()
        else muteOn()
    }

    fun addMuteListener(muteListener: YoutubePlayerMuteListener): Boolean {
        return muteListeners.add(muteListener)
    }

    fun removeMuteListener(muteListener: YoutubePlayerMuteListener): Boolean {
        return muteListeners.remove(muteListener)
    }


}