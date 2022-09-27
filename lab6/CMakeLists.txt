cmake_minimum_required(VERSION 3.21)
project(lab6)

set(CMAKE_CXX_STANDARD 20)

add_executable(lab6 main.cpp)
add_compile_options(-pthread)
target_link_libraries(${PROJECT_NAME} pthread)
