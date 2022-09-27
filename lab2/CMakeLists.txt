cmake_minimum_required(VERSION 3.21)
project(lab2)

set(CMAKE_CXX_STANDARD 20)
add_compile_options(-pthread)

add_executable(lab2 main.c)
target_link_libraries(${PROJECT_NAME} pthread)