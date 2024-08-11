//💡In the Beginning, PaPaGuy wrote beautiful Codes < /> 💜❤️ //
package com.papaguycodes.exifeditor.utils

import android.media.ExifInterface
import com.papaguycodes.exifeditor.models.ExifData
import java.io.File

object ExifUtils {

    fun getExifDataFromFile(filePath: String): List<ExifData> {
        val exifInterface = ExifInterface(File(filePath))
        val exifDataList = mutableListOf<ExifData>()

        // List of EXIF tags to be displayed
        val exifTags = mapOf(
        ExifInterface.TAG_DATETIME to "Date and Time",
        ExifInterface.TAG_MAKE to "Camera Make",
        ExifInterface.TAG_MODEL to "Camera Model",
        ExifInterface.TAG_FOCUS_DISTANCE to "Focus Distance",
        ExifInterface.TAG_ISO to "ISO",
        ExifInterface.TAG_FNUMBER to "F-Number",
        ExifInterface.TAG_FLASH to "Flash",
        ExifInterface.TAG_WHITE_BALANCE to "White Balance",
        ExifInterface.TAG_GPS_LATITUDE to "GPS Latitude",
        ExifInterface.TAG_GPS_LONGITUDE to "GPS Longitude",
        ExifInterface.TAG_GPS_ALTITUDE to "GPS Altitude",
        ExifInterface.TAG_GPS_DATESTAMP to "GPS Date Stamp",
        ExifInterface.TAG_GPS_TIMESTAMP to "GPS Time Stamp",
        ExifInterface.TAG_APERTURE to "Aperture",
        ExifInterface.TAG_SHUTTER_SPEED to "Shutter Speed",
        ExifInterface.TAG_BRIGHTNESS_VALUE to "Brightness Value",
        ExifInterface.TAG_CONTRAST to "Contrast",
        ExifInterface.TAG_SATURATION to "Saturation",
        ExifInterface.TAG_SHARPNESS to "Sharpness",
        ExifInterface.TAG_METERING_MODE to "Metering Mode",
        ExifInterface.TAG_SCENE_TYPE to "Scene Type",
        ExifInterface.TAG_LENS_MAKE to "Lens Make",
        ExifInterface.TAG_LENS_MODEL to "Lens Model",
        ExifInterface.TAG_EXPOSURE_MODE to "Exposure Mode",
        ExifInterface.TAG_COLOR_SPACE to "Color Space",
        ExifInterface.TAG_IMAGE_UNIQUE_ID to "Image Unique ID",
        ExifInterface.TAG_OWNER_NAME to "Owner Name",
        ExifInterface.TAG_CAMERA_SERIAL_NUMBER to "Camera Serial Number",
        ExifInterface.TAG_SOFTWARE to "Software"
    )

    fun getTagDescription(tag: String): String? {
        return exifTags[tag]
    }

        // Retrieve EXIF data
        tags.forEach { tag ->
            val value = exifInterface.getAttribute(tag)
            if (!value.isNullOrEmpty()) {
                exifDataList.add(ExifData(tag, value))
            }
        }

        return exifDataList
    }

    fun setExifDataToFile(filePath: String, exifData: List<ExifData>) {
        val exifInterface = ExifInterface(File(filePath))
        exifData.forEach { data ->
            exifInterface.setAttribute(data.tag, data.value)
        }
        exifInterface.saveAttributes()
    }
}
