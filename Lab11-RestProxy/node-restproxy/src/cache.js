class Cache {
	constructor() {
		this.cache = [];
	}

	get(key) {
		return this.cache.find(element => element.key === key);
	}

    getLastElement() {
        return this.cache[this.cache.length - 1];
    }

    getCache() {
        return this.cache;
    }

    set(key, value) {
        this.cache.push({ key, value });
    }

    delete(key) {
        this.cache = this.cache.filter(element => element.key !== key);
        console.log(this.cache);
    }
}

let cache;

module.exports = {
    // Implement Cache as Singleton
	getCacheInstance: () => {
		if (cache === undefined) {
			cache = new Cache();
		}
		return cache;
	},
};
