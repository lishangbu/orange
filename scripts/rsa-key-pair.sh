#!/bin/sh
# Author: Shangbu Li
# You must run this script before running the application

# 获取脚本所在的目录并切换到上一级目录
ROOT_DIR=$(dirname "$(dirname "$0")")

cd $ROOT_DIR/orange-application/orange-admin-server/src/main/resources

openssl genpkey -algorithm RSA -out private_key.pem -pkeyopt rsa_keygen_bits:2048
openssl rsa -pubout -in private_key.pem -out public_key.pem