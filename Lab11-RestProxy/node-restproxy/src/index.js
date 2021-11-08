const axios = require('axios');
const express = require('express');

const { getCacheInstance } = require('./cache');

const app = express();

app.get('/', async (req, res) => {
  // Check if last cache in 120s
  const lastCache = getCacheInstance().getLastElement();
  if (+ new Date() / 1000 - lastCache?.key < 120) {
    return res.send(lastCache.value);
  }

  // Otherwise, fetch from API
  const { data } = await axios.get('http://worldtimeapi.org/api/timezone/Asia/Bangkok');
  getCacheInstance().set(data.unixtime, data);
  return res.send(data);
});

app.delete('/delete/:id', async (req, res) => {
  // Delete from cache
  getCacheInstance().delete(parseInt(req.params.id))
  res.send({});
});

// Start server on port 5001
app.listen(5001, () => {
  console.log('Example app listening on port 5001!');
});