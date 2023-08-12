package com.example.chatjet

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import io.getstream.chat.android.ui.channel.list.adapter.ChannelListItem
import io.getstream.chat.android.ui.channel.list.viewmodel.ChannelListViewModel
import io.getstream.chat.android.ui.channel.list.viewmodel.factory.ChannelListViewModelFactory

@Composable
fun ChannelListScreen(
    channelViewModel: ChannelListViewModel = viewModel(
        factory = ChannelListViewModelFactory()
    ),
) {
    val state by channelViewModel.state.observeAsState()
    val channelState = state ?: return

    Box (
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ){
        if(channelState.isLoading) {
            CircularProgressIndicator()
        }
        else {
            LazyColumn(Modifier.fillMaxSize()) {
                items(channelState.channels) {channel ->
                    ChannelListItem(channel)
                    Divider()

                }
            }
        }
    }
}