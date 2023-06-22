package com.example.suprheroesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults.cardElevation
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.suprheroesapp.model.Hero
import com.example.suprheroesapp.model.HeroesRepository.heroes
import com.example.suprheroesapp.ui.theme.SuprheroesAppTheme

@Composable
fun SuperheroApp() {
    @OptIn(ExperimentalMaterial3Api::class)
    Scaffold(
        topBar = {
            SuperheroesTopAppBar()
        }
    ) { it ->
        LazyColumn(contentPadding = it) {
            items(heroes) {
                SuperheroListItem(
                    hero = it,
                    modifier = Modifier.padding(
                        horizontal = dimensionResource(id = R.dimen.padding_medium),
                        vertical = dimensionResource(id = R.dimen.padding_small)
                    )
                )
            }
        }
    }
}

@Composable
fun SuperheroListItem(
    hero: Hero,
    modifier: Modifier = Modifier
        .clip(MaterialTheme.shapes.medium)
        .height(dimensionResource(id = R.dimen.image_size))
        .padding(dimensionResource(id = R.dimen.padding_medium))
) {
    Card(
        modifier = modifier,
        elevation = cardElevation(2.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(id = R.dimen.padding_medium))
                .sizeIn(minHeight = dimensionResource(id = R.dimen.image_size))
        ) {
            SuperheroInfo(hero.nameRes, hero.descriptionRes, modifier = Modifier.weight(1f))
            Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.padding_medium)))
            SuperheroIcon(hero.imageRes)
        }
    }
}

@Composable
fun SuperheroesTopAppBar(modifier: Modifier = Modifier) {
    @OptIn(ExperimentalMaterial3Api::class)
    CenterAlignedTopAppBar (
        title = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = stringResource(id = R.string.app_top_bar),
                    style = MaterialTheme.typography.displayLarge
                )
            }
        },
        modifier = modifier
    )
}

@Composable
fun SuperheroInfo(
    @StringRes heroName: Int,
    @StringRes heroDescription: Int,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(heroName),
            style = MaterialTheme.typography.displaySmall,
        )

        Text(
            text = stringResource(heroDescription),
            style = MaterialTheme.typography.bodyLarge,
        )
    }
}
@Composable
fun SuperheroIcon(
    @DrawableRes heroIcon: Int,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier
        .size(dimensionResource(id = R.dimen.image_size))
        .clip(MaterialTheme.shapes.small),
    ) {
        Image(
            painter = painterResource(heroIcon),
            contentDescription = null,
            alignment = Alignment.TopCenter,
            contentScale = ContentScale.FillWidth
        )
    }
}