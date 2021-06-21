package com.codingtroops.composesample.feature.food

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Colors
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.codingtroops.composesample.feature.category.FoodCategoryDetailsViewModel
import com.codingtroops.composesample.feature.category.FoodCategoryViewModelFactory
import com.codingtroops.composesample.feature.entry.AppNavigationController
import com.codingtroops.composesample.ui.theme.ComposeSampleTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.max
import coil.transform.CircleCropTransformation
import com.google.accompanist.coil.rememberCoilPainter
import java.lang.Float.min

@Composable
fun FoodCategoryDetailsScreen(viewModel: FoodCategoryDetailsViewModel, categoryName: String) {
//    val scrollState = rememberScrollState()
//    val offset = min(1f, 1 - (scrollState.value / 600f))

    var profilePictureState by remember { mutableStateOf(FoodCategoryProfileState.Normal) }
    val transition = updateTransition(targetState = profilePictureState, label = "")
    val color by transition.animateColor(targetValueByState = { state -> state.color }, label = "")
    val size by transition.animateDp(targetValueByState = { state -> state.size }, label = "")
    val borderValue by transition.animateDp(
        targetValueByState = { state -> state.borderSize },
        label = ""
    )

    Column {
        Card(
            modifier = Modifier.padding(16.dp),
            shape = CircleShape,
            border = BorderStroke(
                width = borderValue,
                color = color
            ),
            elevation = 4.dp
        ) {
            Image(
                painter = rememberCoilPainter(
                    request = "https:\\/\\/www.themealdb.com\\/images\\/media\\/meals\\/1548772327.jpg",
                    requestBuilder = {
                        transformations(CircleCropTransformation())
                    },
                ),
                modifier = Modifier.size(size),
                contentDescription = "Food category thumbnail picture",
            )
        }
        Button(onClick = {
            profilePictureState = if (profilePictureState == FoodCategoryProfileState.Normal)
                FoodCategoryProfileState.Expanded
            else
                FoodCategoryProfileState.Normal
        }, modifier = Modifier.padding(16.dp)) { }
        Column(
            //modifier = Modifier.verticalScroll(scrollState)
        ) {
            Button(onClick = {}, modifier = Modifier.padding(16.dp), content = { })
            Button(onClick = {}, modifier = Modifier.padding(16.dp), content = { })
            Button(onClick = {}, modifier = Modifier.padding(16.dp), content = { })
            Button(onClick = {}, modifier = Modifier.padding(16.dp), content = { })
            Button(onClick = {}, modifier = Modifier.padding(16.dp), content = { })
            Button(onClick = {}, modifier = Modifier.padding(16.dp), content = { })
            Button(onClick = {}, modifier = Modifier.padding(16.dp), content = { })
            Button(onClick = {}, modifier = Modifier.padding(16.dp), content = { })
            Button(onClick = {}, modifier = Modifier.padding(16.dp), content = { })
            Button(onClick = {}, modifier = Modifier.padding(16.dp), content = { })
            Button(onClick = {}, modifier = Modifier.padding(16.dp), content = { })
            Button(onClick = {}, modifier = Modifier.padding(16.dp), content = { })
            Button(onClick = {}, modifier = Modifier.padding(16.dp), content = { })
            Button(onClick = {}, modifier = Modifier.padding(16.dp), content = { })
            Button(onClick = {}, modifier = Modifier.padding(16.dp), content = { })
            Button(onClick = {}, modifier = Modifier.padding(16.dp), content = { })
            Button(onClick = {}, modifier = Modifier.padding(16.dp), content = { })
            Button(onClick = {}, modifier = Modifier.padding(16.dp), content = { })
        }
    }
}


private enum class FoodCategoryProfileState(val color: Color, val size: Dp, val borderSize: Dp) {
    Normal(Color.Magenta, 120.dp, 1.dp),
    Expanded(Color.Green, 240.dp, 4.dp)
}

@Preview(showBackground = true)
@Composable
fun FoodCategoryDetailsDefaultPreview() {
    ComposeSampleTheme {
        FoodCategoryDetailsScreen(viewModel(factory = FoodCategoryViewModelFactory("Lamb")), "Lamb")
    }
}