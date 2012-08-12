#!/bin/bash

function getlib {
    echo "Exporting source from SVN..."
    svn export http://zxing.googlecode.com/svn/trunk/core library-zxing/core
    svn export http://zxing.googlecode.com/svn/trunk/android library-zxing/android
    echo "Patching zxing android library project"
    echo "android.library=true" >> library-zxing/android/project.properties
    echo "Calculating MD5 hash..."
    find library-zxing/ -type f -print0 | xargs -0 md5sum >> library-zxing.sum
}

echo "Checking existing zxing library source integrity..."
if [[ `md5sum -c library-zxing.sum 2>/dev/null | grep FAILED | wc -l` > 0 ]]; then
    rm -f library-zxing.sum
    rm -rf library-zxing/
    echo "Existing zxing source is corrupted!"
    getlib
    exit
fi

echo "zxing library existing source OK"
