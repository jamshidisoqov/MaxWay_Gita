package uz.gita.maxway_gita.presentation.screens.history.utils

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import uz.gita.maxway_gita.presentation.theme.MaxWayGitaTheme
import uz.gita.maxway_gita.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyActionBar() {
    TopAppBar(
        title = {
            Text(
                modifier = Modifier.fillMaxWidth()
                    .padding(start = 110.dp),
                text = "Zaqas"
            )
        },
        navigationIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    painter = painterResource(id = R.drawable.arrow_back),
                    contentDescription = null,
                    Modifier.size(18.dp)
                )
            }
        },
    )
}

@Composable
@Preview
fun MyActionBarPreview() {
    MaxWayGitaTheme {
        MyActionBar()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyActionBarWithDelete() {
    TopAppBar(
        title = {
            Text(
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
                text = "Zaqas"
            )
        },
        navigationIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    painter = painterResource(id = R.drawable.arrow_back),
                    contentDescription = null,
                    modifier = Modifier.size(18.dp)
                )
            }
        },
        actions = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    painter = painterResource(id = R.drawable.delete),
                    contentDescription = null,
                    modifier = Modifier.size(20.dp)
                )
            }
        }
    )
}

@Composable
@Preview
fun MyActionBarWithDeletePreview() {
    MaxWayGitaTheme {
        MyActionBarWithDelete()
    }
}