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
        val tags = listOf(
            ExifInterface.TAG_DATETIME,
            ExifInterface.TAG_GPS_LATITUDE,
            ExifInterface.TAG_GPS_LONGITUDE,
            ExifInterface.TAG_MAKE,
            ExifInterface.TAG_MODEL,
            ExifInterface.TAG_IMAGE_WIDTH,
            ExifInterface.TAG_IMAGE_LENGTH,
            ExifInterface.TAG_EXPOSURE_TIME,
            ExifInterface.TAG_F_NUMBER,
            ExifInterface.TAG_ISO_SPEED_RATINGS,
            ExifInterface.TAG_FLASH,
            ExifInterface.TAG_FOCAL_LENGTH,
            ExifInterface.TAG_WHITE_BALANCE,
            ExifInterface.TAG_GPS_ALTITUDE,
            ExifInterface.TAG_GPS_PROCESSING_METHOD,
            ExifInterface.TAG_ORIENTATION,
            ExifInterface.TAG_APERTURE_VALUE,
            ExifInterface.TAG_BRIGHTNESS_VALUE,
            ExifInterface.TAG_GPS_TIMESTAMP,
            ExifInterface.TAG_SUBSEC_TIME,
            ExifInterface.TAG_SUBSEC_TIME_DIGITIZED,
            ExifInterface.TAG_SUBSEC_TIME_ORIGINAL,
            ExifInterface.TAG_SHUTTER_SPEED_VALUE,
            ExifInterface.TAG_SUBJECT_DISTANCE,
            ExifInterface.TAG_SUBJECT_AREA,
            ExifInterface.TAG_GPS_SPEED,
            ExifInterface.TAG_GPS_SPEED_REF,
            ExifInterface.TAG_IMAGE_UNIQUE_ID,
            ExifInterface.TAG_SCENE_TYPE,
            ExifInterface.TAG_COMPRESSION,
            ExifInterface.TAG_RESOLUTION_UNIT,
            ExifInterface.TAG_SOFTWARE,
            ExifInterface.TAG_DATE_TIME_DIGITIZED,
            ExifInterface.TAG_DATE_TIME_ORIGINAL,
            ExifInterface.TAG_METERING_MODE,
            ExifInterface.TAG_LIGHT_SOURCE
        )

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
