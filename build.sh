#!/bin/bash

function update_submodules {
    git submodule init
    check_exit_code
    git submodule update
    check_exit_code
}

function get_zxing {
    ./library-zxing.sh
    check_exit_code
}

function update_android {
    android update lib-project -p ./library-actionbarsherlock/library
    check_exit_code
    android update lib-project -p ./library-viewpagerindicator/library
    check_exit_code
    android update lib-project -p ./library-zxing/android
    check_exit_code
    android update project --name uclient -p ./app 
    check_exit_code
}

function build_zxing_core {
    ant -f library-zxing/core/build.xml
    check_exit_code
    cp library-zxing/core/core.jar library-zxing/android/libs/
}

function build_debug {
    ant -f app/build.xml debug
    check_exit_code

}

function build_release {
    ant -f app/build.xml release
    check_exit_code
}

function check_exit_code {
    retcode=$?
    if [[ $retcode != 0 ]] ; then
        exit $retcode
    fi
}

function clean {
    ant -f library-zxing/core/build.xml clean
    ant -f library-zxing/android/build.xml cleann
    ant -f library-actionbarsherlock/library/build.xml clean
    ant -f library-viewpagerindicator/library/build.xml clean
    ant -f app/build.xml clean
}

function main {
    update_submodules
    get_zxing
    update_android
    build_zxing_core
    build_debug
}

main
