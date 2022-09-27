#include <iostream>
#include <unistd.h>
#include <vector>
#include <pthread.h>
#include <cstring>

void* PrintString(void* args) {
	size_t length = strlen((char*)args);
	usleep(length * 10000 + 1000000);
	std::cout << (char*)args << std::endl;
	return nullptr;
}

int main() {
	std::vector<std::string> strings;
	std::string line;
	while (std::getline(std::cin, line)) {
		strings.push_back(line);
	}

	pthread_t threads[strings.size()];
	for (int i = 0; i < strings.size(); ++i) {
		if (pthread_create(&threads[i], nullptr, PrintString, (void*)strings[i].c_str()) != 0) {
			perror("Cannot create a thread");
			return 1;
		}
	}
	for (pthread_t thread: threads) {
		if (pthread_join(thread, nullptr) != 0) {
			perror("Cannot join a thread");
			return 1;
		}
	}

	return 0;
}
