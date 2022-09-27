cmake_minimum_required(VERSION 3.21)
project(lab4)

set(CMAKE_CXX_STANDARD 20)

add_executable(lab4 main.c)

add_compile_options(-pthread)
target_link_libraries(${PROJECT_NAME} pthread)