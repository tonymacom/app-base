
local key1 = KEYS[1]
local key2 = KEYS[2]
redis.log(redis.LOG_WARNING, "key1 :" .. key1)
redis.log(redis.LOG_WARNING, "key2 :" .. key2)

local value1 =  tonumber(ARGV[1])
local value2 =  tonumber(ARGV[2])

redis.log(redis.LOG_WARNING, ARGV[1])
redis.log(redis.LOG_WARNING, ARGV[2])


return {value1, value2}