cmake_minimum_required(VERSION 3.24)
project(lab8 C)

set(CMAKE_C_STANDARD 23)

add_executable(lab8 main.c)
add_compile_options(-pthread)
target_link_libraries(${PROJECT_NAME} pthread)
