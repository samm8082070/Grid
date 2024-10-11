package data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(@StringRes val title : Int, val numberOfCourses : Int, @DrawableRes val img : Int ){

}
